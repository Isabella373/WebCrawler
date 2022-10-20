package com.udacity.webcrawler.json;

import java.io.Reader;
import java.nio.file.Path;
import java.util.Objects;
import com.fasterxml.jackson;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * A static utility class that loads a JSON configuration file.
 */
@JsonDeserialize(builder = CrawlerConfiguration.Builder.class)
public final class ConfigurationLoader {

  private final Path path;

  /**
   * Create a {@link ConfigurationLoader} that loads configuration from the given {@link Path}.
   */
  public ConfigurationLoader(Path path) {
    this.path = Objects.requireNonNull(path);
  }

  /**
   * Loads configuration from this {@link ConfigurationLoader}'s path
   *
   * @return the loaded {@link CrawlerConfiguration}.
   */
  public CrawlerConfiguration load() throws IOException{
    // TODO: Fill in this method.
    try(Reader reader = Files.newBufferedReader(path)){
      return read(reader);
    }catch(IOException e){
      e.printStackTrace();
    }
    finally{
      if(reader!=null){
        reader.close();
      }
    }

    //return new CrawlerConfiguration.Builder().build();
  }

  /**
   * Loads crawler configuration from the given reader.
   *
   * @param reader a Reader pointing to a JSON string that contains crawler configuration.
   * @return a crawler configuration
   */


  public static CrawlerConfiguration read(Reader reader) throws IOException{
    // This is here to get rid of the unused variable warning.
    Objects.requireNonNull(reader);
    // TODO: Fill in this method
    ObjectMapper objectMapper = new ObjectMapper();
    CrawlerConfiguration klass = null;
    try(klass = objectMapper.readValue(reader, CrawlerConfiguration.Builder.class)){
      return klass;
    }catch(IOException e){
      e.printStackTrace();
    }



    //return new CrawlerConfiguration.Builder().build();
  }
}
